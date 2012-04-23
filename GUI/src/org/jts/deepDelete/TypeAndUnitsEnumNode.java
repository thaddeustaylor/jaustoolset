/***********           LICENSE HEADER   *******************************
JAUS Tool Set
Copyright (c)  2011, United States Government
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

Redistributions of source code must retain the above copyright notice,
this list of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright
notice, this list of conditions and the following disclaimer in the
documentation and/or other materials provided with the distribution.

Neither the name of the United States Government nor the names of
its contributors may be used to endorse or promote products derived from
this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
 *********************  END OF LICENSE ***********************************/

package org.jts.deepDelete;

import com.u2d.generated.TypeAndUnitsEnum;
import com.u2d.generated.VariableField;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * A TreeRepNode wrapping a type-and-units enum instance.  See ConcreteTreeRepNode for a full picture of a
 * TreeRepNode implementation's purpose and responsibilities.
 * @author idurkan
 */
class TypeAndUnitsEnumNode extends ConcreteTreeRepNode {
    private TypeAndUnitsEnum typeUnitsEnum = null;

    /**
     * Create a TypeAndUnitsEnumNode wrapping the given TypeAndUnitsEnum element.
     * @param element
     */
    TypeAndUnitsEnumNode(TypeAndUnitsEnum element) {
        super(element,element.getID(), "TypeAndUnitsEnum", element.getName().toString());
        typeUnitsEnum = element;
    }

    /**
     * Static factory method that creates a TypeAndUnitsEnumNode and adds it to the tree representation.
     * @param typeUnitsEnum
     * @param parent
     * @param nodeSet
     * @param leafSet
     */
    public static void addInstance(TypeAndUnitsEnum typeUnitsEnum, ConcreteTreeRepNode parent, MutableSet<TreeRepNode> nodeSet, Set<TreeRepNode> leafSet) {
        ConcreteTreeRepNode newNode = new TypeAndUnitsEnumNode(typeUnitsEnum);
        ConcreteTreeRepNode.addNodeToTree(newNode, parent, nodeSet, leafSet);
    }

    /**
     * See ConcreteTreeRepNode.makeChildren
     * @param nodeSet
     * @param leafSet
     * @return
     */
    @Override
    protected boolean makeChildren(MutableSet<TreeRepNode> nodeSet, Set<TreeRepNode> leafSet) {
        boolean hasChildren = false;

        if (typeUnitsEnum.getValueSet() != null) {
            ValueSetNode.addInstance(typeUnitsEnum.getValueSet(), this, nodeSet, leafSet);
        }

        return hasChildren;
    }

    /**
     * See ConcreteTreeRepNode.getDependantsInDatabase
     * @param hbSession
     * @return
     */
    @Override
    public List<TreeRepNode> getDependantsInDatabase(Session hbSession) {
        ArrayList dependants = new ArrayList<TreeRepNode>();

        // find variable field dependants in database.
        String queryVarFields =
                "select varField from VariableField varField "
                + "join varField.typeAndUnitsEnums tuEnum "
                + "where tuEnum.id=:ID";

        Query hibQuery = hbSession.createQuery(queryVarFields);
        hibQuery.setParameter("ID", typeUnitsEnum.getID());

        List varfieldsResult = hibQuery.list();

        // create node wrapping each found list.
        for (Object obj : varfieldsResult) {
            dependants.add(new VariableFieldNode(DeepDeleteUtil.getProxyImpl((VariableField)obj)));
        }

        return dependants;
    }
}


