/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturestore.fobject.soft;

import furniturestore.fobject.FObject;

public class SoftFurniture extends FObject{
    protected String fPacking;//нибивка
    protected String fSheathing;//обшивка
    
    public SoftFurniture()
    {
        super();
        fPacking=new String();
        fSheathing=new String();
        generateName();
    }
    
    public void setPacking(String packing)
    {
        fPacking=packing;
    }
    public void setSheathing(String sheathing)
    {
        fSheathing=sheathing;
    }

    @Override
    protected void generateName() {
        fName="Unknown_Soft_Furniture";
    }
    
    @Override
   public String toString()
   {
       String str;
       str=super.toString()+"_Обивка:"+fSheathing+"_Набивка:"+fPacking;
       return str;
   }
    
}
