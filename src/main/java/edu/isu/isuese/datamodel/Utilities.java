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

public class Utilities {

    public static Component findComponent(RefType type, String compKey) {
        switch(type) {
            case CONSTRUCTOR:
                return findConstructor(compKey);
                break;
            case FIELD:
                return findField(compKey);
                break;
            case INITIALIZER:
                return findInitializer(compKey);
                break;
            case LITERAL:
                return findLiteral(compKey);
                break;
            case METHOD:
                return findMethod(compKey);
                break;
            case TYPE:
                return findType(compKey);
                break;
        }

        return null;

    }

    private static Type findType(String compKey) {
        Type val = findClass(compKey);
        if (val == null) val = findEnum(compKey);
        if (val == null) val = findInterface(compKey);
        return val;
    }

    private static Type findClass(String compKey) {
        return Class.findFirst("compKey = ?", compKey);
    }

    private static Type findEnum(String compKey) {
        return Enum.findFirst("compKey = ?", compKey);
    }

    private static Type findInterface(String compKey) {
        return Interface.findFirst("compKey = ?", compKey);
    }

    private static Member findInitializer(String compKey) {
        return Initializer.findFirst("compKey = ?", compKey);
    }

    private static Member findLiteral(String compKey) {
        return Literal.findFirst("compKey = ?", compKey);
    }

    private static Member findField(String compKey) {
        return Field.findFirst("compKey = ?", compKey);
    }

    private static Member findMethod(String compKey) {
        return Method.findFirst("compKey = ?", compKey);
    }

    private static Member findConstructor(String compKey) {
        return Constructor.findFirst("compKey = ?", compKey);
    }
}
