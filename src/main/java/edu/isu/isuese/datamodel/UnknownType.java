/**
 * The MIT License (MIT)
 *
 * MSUSEL DataModel
 * Copyright (c) 2015-2019 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory and Idaho State University, Informatics and
 * Computer Science, Empirical Software Engineering Laboratory
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package edu.isu.isuese.datamodel;

import com.google.common.collect.Lists;
import lombok.Builder;
import org.javalite.activejdbc.annotations.BelongsTo;

import java.util.List;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
//@BelongsTo(parent = Project.class, foreignKeyName = "project_id")
public class UnknownType /*extends Type*/ {

//    public UnknownType() {}
//
//    @Builder(buildMethodName = "create")
//    public UnknownType(String name, int start, int end, String compKey, Accessibility accessibility) {
//        set("name", name, "start", start, "end", end, "compKey", compKey, "qualified_name", name);
//        if (accessibility != null)
//            setAccessibility(Accessibility.PUBLIC);
//        save();
//    }
//
//    @Override
//    public void updateKey() {
//        Project proj = parent(Project.class);
//        if (proj != null)
//            setCompKey(proj.getProjectKey() + ":" + getName());
//    }
//
//    @Override
//    protected Type copyType(String oldPrefix, String newPrefix) {
//        return UnknownType.builder()
//                .name(this.getName())
//                .compKey(this.getCompKey().replace(oldPrefix, newPrefix))
//                .accessibility(this.getAccessibility())
//                .start(this.getStart())
//                .end(this.getEnd())
//                .create();
//    }
//
//    @Override
//    public String getFullName() {
//        return getName();
//    }
//
//    @Override
//    public Namespace getParentNamespace() {
//        return null;
//    }
//
//    @Override
//    public List<System> getParentSystems() {
//        return getParentProject().getParentSystems();
//    }
//
//    /**
//     * @return The parent system of this type or null if no such parent has been defined
//     */
//    @Override
//    public System getParentSystem() {
//        return getParentProject().getParentSystem();
//    }
//
//    @Override
//    public List<Project> getParentProjects() {
//        List<Project> list = Lists.newArrayList();
//        if (getParentProject() != null)
//            list.add(getParentProject());
//
//        return list;
//    }
//
//    /**
//     * @return The parent project of this type or null if no such parent has been defined
//     */
//    @Override
//    public Project getParentProject() {
//        return parent(Project.class);
//    }
//
//    @Override
//    public List<Module> getParentModules() {
//        return Lists.newArrayList();
//    }
//
//    /**
//     * @return The parent module of this type or null if no such parent has been defined
//     */
//    @Override
//    public Module getParentModule() {
//        return null;
//    }
//
//    @Override
//    public List<Namespace> getParentNamespaces() {
//        return Lists.newArrayList();
//    }
//
//    @Override
//    public List<File> getParentFiles() {
//        return Lists.newArrayList();
//    }
//
//    @Override
//    public File getParentFile() {
//        return null;
//    }
//
//    /**
//     * @return The parent Measurable of this Measurable
//     */
//    @Override
//    public Measurable getParent() {
//        return getParentProject();
//    }
}
