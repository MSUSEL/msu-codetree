package edu.isu.isuese.datamodel;

import org.javalite.activejdbc.test.DBSpec;
import org.junit.Test;

public class FieldSpec extends DBSpec {

    @Test
    public void shouldValidateRequiredAttributes() {
        Member member = new Field();
        a(member).shouldBe("valid");
//        //a(member.errors().get("author")).shouldBeEqual("Author must be provided");
        member.set("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        member.setAccessibility(Accessibility.PUBLIC);
        a(member).shouldBe("valid");
        member.save();
        member = Field.findById(1);
        a(member.getId()).shouldNotBeNull();
        a(member.get("accessibility")).shouldBeEqual(Accessibility.PUBLIC.value());
        a(member.getAccessibility()).shouldBeEqual(Accessibility.PUBLIC);
        a(member.get("name")).shouldBeEqual("TestClass");
        a(member.get("compKey")).shouldBeEqual("TestClass");
        a(member.get("start")).shouldBeEqual(1);
        a(member.get("end")).shouldBeEqual(100);
        a(Field.count()).shouldBeEqual(1);
    }

    @Test
    public void canSetType() {
        Field field = Field.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        field.setAccessibility(Accessibility.PUBLIC);
        field.save();

        TypeRef typeRef = TypeRef.createIt("typeName", "typeRef", "dimensions", null);
        typeRef.setType(TypeRefType.Type);
        field.setType(typeRef);

        a(field.getAll(TypeRef.class).size()).shouldBeEqual(1);

        typeRef = TypeRef.createIt("typeName", "typeRef2", "dimensions", null);
        field.setType(typeRef);

        a(field.getAll(TypeRef.class).size()).shouldBeEqual(1);
        a(TypeRef.count()).shouldBeEqual(1);
    }

    @Test
    public void onlyAddsOneTypeRef() {
        TypedMember field = Field.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        TypeRef typeRef = TypeRef.createIt("typeName", "typeRef", "dimensions", null);
        TypeRef typeRef2 = TypeRef.createIt("typeName", "typeRef2", "dimensions", null);

        field.setType(typeRef);
        a(field.getAll(TypeRef.class).size()).shouldBeEqual(1);
        field.setType(typeRef2);
        a(field.getAll(TypeRef.class).size()).shouldBeEqual(1);
        a(TypeRef.count()).shouldBeEqual(1);
    }

    @Test
    public void canAddModifier() {
        Field field = Field.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        field.setAccessibility(Accessibility.PUBLIC);
        field.addModifier(Modifier.Values.STATIC.name());
        field.save();

        a(field.findById(1).getAll(Modifier.class).size()).shouldBeEqual(1);
    }

    @Test
    public void canRemoveModifier() {
        Field field = Field.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        field.setAccessibility(Accessibility.PUBLIC);
        field.addModifier(Modifier.Values.STATIC.name());
        field.save();

        field = Field.findById(1);
        field.removeModifier(Modifier.Values.STATIC.name());
        a(field.getAll(Modifier.class).size()).shouldBeEqual(0);
        a(FieldsModifiers.count()).shouldBeEqual(0);
    }

    @Test
    public void deleteHandlesCorrectly() {
        Field field = Field.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        field.setAccessibility(Accessibility.PUBLIC);
        field.save();

        TypeRef typeRef = TypeRef.createIt("typeName", "typeRef", "dimensions", null);
        typeRef.setType(TypeRefType.Type);
        field.setType(typeRef);

        field.delete(true);
        a(Parameter.count()).shouldBeEqual(0);
        a(FieldsModifiers.count()).shouldBeEqual(0);
        a(TypeRef.count()).shouldBeEqual(0);
    }
}
