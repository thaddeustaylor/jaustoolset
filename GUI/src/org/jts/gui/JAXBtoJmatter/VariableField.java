/***********           LICENSE HEADER   *******************************
JAUS Tool Set
Copyright (c)  2010, United States Government
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

package org.jts.gui.JAXBtoJmatter;

import org.jts.gui.importJSIDL.ImportMessages;

import com.u2d.app.Context;


// This class converts a JAXB VariableField to a JMatter VariableField
public class VariableField
{
	public static Object getStored( Object jaxbObject, Long generatedId )
	{
		org.jts.gui.util.QueryBuilder builder = new org.jts.gui.util.QueryBuilder();
		builder.setTableName( "VariableField" );
		builder.addNameArg();
		builder.addOptionalArg();
		
		return builder.getStored( jaxbObject, generatedId );
	}

	// This static method does the conversion from JAXB Binding to JMatter object
	public static com.u2d.generated.VariableField lookupOrCreate(org.jts.jsidl.binding.VariableField jxVariableField ) 
	{
		// Get and handle on a hibernate session
		com.u2d.persist.HBMSingleSession persistenceMechanism = (com.u2d.persist.HBMSingleSession) Context.getInstance().getPersistenceMechanism(); 

		com.u2d.generated.VariableField jmVariableField = (com.u2d.generated.VariableField)getStored( jxVariableField, null );

		// if the jmVariableField object is unique, we will create it and add it to the db
		if( jmVariableField == null )
		{
			jmVariableField = new com.u2d.generated.VariableField();
			
			// name
			jmVariableField.getName().setValue( jxVariableField.getName() );

		    // Optional
		    jmVariableField.getOptional().setValue( jxVariableField.isOptional() );
		    
		    // Interpretation
		    if(jxVariableField.getInterpretation() != null)
		    {
		    	String interpretation = jxVariableField.getInterpretation().replaceAll("\\s\\s+ | \\n | \\r | \\t", " ").trim();
				if(interpretation.length() > 255)
				{
					String temp = interpretation.substring(0, 255);
					jmVariableField.getInterpretation().setValue( temp );

					ImportMessages importMsgs = ImportMessages.getInstance();
					importMsgs.add(ImportMessages.MessageType.WARNING, "VariableField ("+jxVariableField.getName()+") interpretation attribute was truncated to: \"" + temp +"\"");
				}
				else
				{
					jmVariableField.getInterpretation().setValue(interpretation);
				}
		    }

		    java.util.List jxList = jxVariableField.getTypeAndUnitsField().getTypeAndUnitsEnum();
		    if(jxList != null)
		    {
		    	java.util.List jmList = jmVariableField.getTypeAndUnitsEnums().getItems();
		    	for(int i = 0; i < jxList.size(); i++)
		    	{
		    		com.u2d.generated.TypeAndUnitsEnum typeAndUnitsEnum = TypeAndUnitsEnum.lookupOrCreate((org.jts.jsidl.binding.TypeAndUnitsEnum) jxList.get(i)); 
		    		jmList.add(typeAndUnitsEnum);
		    		persistenceMechanism.updateAssociation(jmVariableField, typeAndUnitsEnum);
		    	}
		    }
		    
			// Saves the VariableField
			persistenceMechanism.save(jmVariableField);
		}

		jmVariableField.firePropertyChange("VariableField", jmVariableField, jmVariableField);

		return jmVariableField;
	}	
}
