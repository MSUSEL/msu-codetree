package edu.isu.isuese.datamodel;

import org.javalite.activejdbc.test.DBSpec;
import org.junit.Test;

public class ClassSpec extends DBSpec {

    @Test
    public void shouldValidateRequiredAttributes() {
        Type type = new Class();
        a(type).shouldBe("valid");
//        //a(type.errors().get("author")).shouldBeEqual("Author must be provided");
        type.set("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        type.setAccessibility(Accessibility.PUBLIC);
        a(type).shouldBe("valid");
        type.save();
        type = Class.findById(1);
        a(type.getId()).shouldNotBeNull();
        a(type.get("accessibility")).shouldBeEqual(Accessibility.PUBLIC.value());
        a(type.getAccessibility()).shouldBeEqual(Accessibility.PUBLIC);
        a(type.get("name")).shouldBeEqual("TestClass");
        a(type.get("compKey")).shouldBeEqual("TestClass");
        a(type.get("start")).shouldBeEqual(1);
        a(type.get("end")).shouldBeEqual(100);
        a(Class.count()).shouldBeEqual(1);
    }

    @Test
    public void canAddMembers() {
        Type type = Class.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        type.setAccessibility(Accessibility.PUBLIC);
        type.save();

        Member member = Field.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        member.setAccessibility(Accessibility.PUBLIC);
        member.save();

        type.add(member);
        a(member.getId()).shouldNotBeNull();
    }

    @Test
    public void canRemoveMembers() {
        Type type = Class.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        type.setAccessibility(Accessibility.PUBLIC);
        type.save();

        Member member = Field.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        member.setAccessibility(Accessibility.PUBLIC);
        member.save();

        type.add(member);
        a(type.getAll(Field.class).size()).shouldBeEqual(1);

        type.remove(member);
        a(type.getAll(Field.class).size()).shouldBeEqual(0);
    }

    @Test
    public void canAddModifier() {
        Type type = Class.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        type.setAccessibility(Accessibility.PUBLIC);
        type.addModifier(Modifier.Values.STATIC.name());
        type.save();

        a(Class.findById(1).getAll(Modifier.class).size()).shouldBeEqual(1);
    }

    @Test
    public void canRemoveModifier() {
        Type type = Class.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        type.setAccessibility(Accessibility.PUBLIC);
        type.addModifier(Modifier.Values.STATIC.name());
        type.save();

        type = Class.findById(1);
        type.removeModifier(Modifier.Values.STATIC.name());
        a(type.getAll(Modifier.class).size()).shouldBeEqual(0);
    }

    @Test
    public void deleteHandlesCorrectly() {
        Type type = Class.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        type.setAccessibility(Accessibility.PUBLIC);
        type.save();
        type.addModifier(Modifier.Values.STATIC.name());

        Member member = Field.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        member.setAccessibility(Accessibility.PUBLIC);
        member.save();

        type.add(member);

        type.delete(true);
        a(Field.count()).shouldBeEqual(0);
        a(ClassesModifiers.count()).shouldBeEqual(0);
    }

    @Test
    public void parentsWorksCorrectly() {
        File file = File.createIt("fileKey", "fileKey", "name", "file");
        file.setType(FileType.SOURCE);
        file.save();

        Type type = Class.createIt("name", "TestClass", "start", 1, "end", 100, "compKey", "TestClass");
        type.setAccessibility(Accessibility.PUBLIC);
        type.save();

        Type type2 = Class.createIt("name", "TestClass2", "start", 1, "end", 100, "compKey", "TestClass");
        type.setAccessibility(Accessibility.PUBLIC);
        type.save();

        type.add(type2);
        file.add(type);
        file.add(type2);

        a(file.getAll(Class.class).size()).shouldBeEqual(2);
        a(type.getAll(Class.class).size()).shouldBeEqual(1);
    }
}
