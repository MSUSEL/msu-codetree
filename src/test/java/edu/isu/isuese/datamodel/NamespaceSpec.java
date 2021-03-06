package edu.isu.isuese.datamodel;

import org.javalite.activejdbc.test.DBSpec;
import org.junit.Test;

public class NamespaceSpec extends DBSpec {

    @Test
    public void shouldValidateRequiredAttributes() {
        Namespace ns = new Namespace();
        a(ns).shouldBe("valid");
//        //a(ns.errors().get("author")).shouldBeEqual("Author must be provided");
        ns.set("nsKey", "ns", "name", "ns");
        a(ns).shouldBe("valid");
        ns.save();
        ns = Namespace.findById(1);
        a(ns.getId()).shouldNotBeNull();
        a(ns.get("name")).shouldBeEqual("ns");
        a(ns.get("nsKey")).shouldBeEqual("ns");
        a(Namespace.count()).shouldBeEqual(1);
    }

    @Test
    public void canAddFile() {
        Namespace ns = Namespace.createIt("nsKey", "ns", "name", "ns");
        File file = File.createIt("fileKey", "fileKey", "name", "file");
        file.setType(FileType.SOURCE);
        file.save();

        ns.add(file);

        a(ns.getFiles().size()).shouldBeEqual(1);
    }

    @Test
    public void canRemoveFile() {
        Namespace ns = Namespace.createIt("nsKey", "ns", "name", "ns");
        File file = File.createIt("fileKey", "fileKey", "name", "file");
        file.setType(FileType.SOURCE);
        file.save();

        ns.add(file);
        ns = Namespace.findById(1);
        ns.remove(file);

        a(ns.getFiles().isEmpty()).shouldBeTrue();
    }

    @Test
    public void canAddChildNamespace() {
        Namespace ns = Namespace.createIt("nsKey", "ns", "name", "ns");
        Namespace ns2 = Namespace.createIt("nsKey", "ns2", "name", "ns2");

        ns.add(ns2);
        a(ns.getNamespaces().size()).shouldBeEqual(1);
    }

    @Test
    public void canRemoveChildNamespace() {
        Namespace ns = Namespace.createIt("nsKey", "ns", "name", "ns");
        Namespace ns2 = Namespace.createIt("nsKey", "ns2", "name", "ns2");

        ns.add(ns2);
        ns = Namespace.findById(1);
        ns.remove(ns2);
        a(ns.getNamespaces().size()).shouldBeEqual(0);
    }

    @Test
    public void parentsHandleCorrectly() {
        Namespace ns = Namespace.createIt("nsKey", "ns", "name", "ns");
        Namespace ns2 = Namespace.createIt("nsKey", "ns2", "name", "ns2");
        Module module = Module.createIt("moduleKey", "module", "name", "module");

        ns.add(ns2);
        module.add(ns);
        module.add(ns2);

        a(module.getAll(Namespace.class).size()).shouldBeEqual(2);
        a(ns.getAll(Namespace.class).size()).shouldBeEqual(1);
    }

    @Test
    public void deleteHandlesCorrectly() {
        Namespace ns = Namespace.createIt("nsKey", "ns", "name", "ns");
        Namespace ns2 = Namespace.createIt("nsKey", "ns2", "name", "ns2");
        File file = File.createIt("fileKey", "fileKey", "name", "file");
        file.setType(FileType.SOURCE);
        file.save();

        ns.add(ns2);
        ns.add(file);

        ns.delete(true);

        a(Namespace.count()).shouldBeEqual(0);
        a(File.count()).shouldBeEqual(0);
    }
}
