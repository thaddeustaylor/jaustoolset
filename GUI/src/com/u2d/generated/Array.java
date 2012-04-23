/*
 * Array.java
 *
 * This code has been auto-updated by JTS after it has been auto-generated by umlc
 * Created on Wed Oct 05 10:31:04 EDT 2011
 */

package com.u2d.generated;


import com.u2d.model.*;
import com.u2d.app.PersistenceMechanism;
import com.u2d.type.*;
import com.u2d.type.atom.*;
import com.u2d.type.composite.*;
import com.u2d.list.RelationalList;
import com.u2d.reflection.Fld;
import javax.persistence.Entity;
/** place holder for more imports **/


@Entity
public  class Array extends SimpleField {

    
    /** Creates a new instance of Array */
    public Array() {
    }
    public Title title() { 
        StringBuffer text = new StringBuffer();
        text.append(name.title() + " [Array]");
        return new Title(text.toString());
    }    
    


    // ******    name   ******
    private final StringEO name = new StringEO();
    @Fld(label="")
    public StringEO getName() { return name;}

    // ******    optional   ******
    private final BooleanEO optional = new BooleanEO();
    @Fld(label="")
    public BooleanEO getOptional() { return optional;}

    // ******    interpretation   ******
    private final StringEO interpretation = new StringEO();
    public StringEO getInterpretation() { return interpretation;}

   


 
    // *********  dimensions ******
    private final RelationalList dimensions = new RelationalList(Dimension.class);
    public static final Class dimensionsType = Dimension.class;
    public static final int dimensionsRelationType = PersistenceMechanism.MANY_TO_MANY;    
    public static final boolean dimensionsRelationIsInverse = false;
    public RelationalList getDimensions() { return dimensions; } 
 


 
    // ********  arrayElementType ********
    private SimpleField arrayElementType;
    public SimpleField getArrayElementType() {
        return arrayElementType;
    }
    public void setArrayElementType(SimpleField arrayElementType) {
        SimpleField old = this.arrayElementType;
        this.arrayElementType = arrayElementType;
        firePropertyChange("arrayElementType", old, this.arrayElementType );
    }
 
/************** Uncomment the following as needed *****************************/
      public static String[] fieldOrder  = {"name", "optional", "arrayElementType", "dimensions", "interpretation", "referencingElements"};
public static String[] readOnly  = {"referencingElements"};
// ******    referencingElements   ******
   private final StringEO referencingElements = new StringEO("{Records, Arrays}");
   public StringEO getReferencingElements() { return referencingElements;}

      ;
//    public static String[] tabViews          = {"fieldname1", "fieldname2"};

      public static String[] flattenIntoParent = {"optional"};
//    public static String[] flattenIntoParent = {"fieldname1", "fieldname2"};

      ;
//    public static String[] identities = {"fieldname1", "fieldname2"};

      public static String pluralName() { return "Arrays"; }
      /* Specify a color to represnt this class */
//    public static Color colorCode = new Color(0x2332);

      /* Use a different Icon for each instance. Change photoFieldName. */
//    private transient PhotoIconAssistant assistant = 
//                        new PhotoIconAssistant(this, photoFieldname);
//    public Icon iconLg() { return assistant.iconLg(); }
//    public Icon iconSm() { return assistant.iconSm(); }


      /* Specify the default search field for this class */
//    public static String defaultSearchPath = "";


      /* Specify a custom view for this class. 
//    public EView getMainView()
//    {
//       return new CustomArrayView(this);
//    }
/**********************/
/**@Cmd place holder**/        
}
