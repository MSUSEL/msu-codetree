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
package edu.isu.isuese.datamodel.cfg

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
@Singleton
class ControlFlowNodeFactory {

    def createNode(String desc) {
        def contents = desc.split(/_/)

        def type = contents[0]
        def label = contents[1]

        def nodetype = type.split(":")[0]
        def stmttype = type.split(":")[1]

        switch (nodetype) {
            case NodeType.BLOCKEND:
                return BlockEnd.builder().type(StatementType.valueOf(stmttype)).label(Integer.parseInt(label)).create()
            case NodeType.BLOCKSTART:
                return BlockStart.builder().type(StatementType.valueOf(stmttype)).label(Integer.parseInt(label)).create()
            case NodeType.LABELED:
                int intLabel = Integer.parseInt(label.split(":")[0])
                String codeLabel = label.split(":")[1]
                return LabeledStatement.builder().label(intLabel).codeLabel(codeLabel).create()
            case NodeType.LOOPSTART:
                return LoopStart.builder().type(StatementType.valueOf(stmttype)).label(Integer.parseInt(label)).create()
            case NodeType.METHODEND:
                return new MethodEnd()
            case NodeType.METHODSTART:
                return new MethodStart()
            case NodeType.STATEMENT:
                return Statement.builder().type(StatementType.valueOf(stmttype)).label(Integer.parseInt(label)).create()
        }
    }
}
