/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturestore.fobject.soft;

public class SoftChair extends SoftFurniture{
    private boolean fFolding;
    private static int scNum=0;
    private int scId;
    public SoftChair()
    {
        super();
        fFolding=false;
        generateName();
        scNum=1+scNum;
        scId=scNum;
    }
    
    public void setFolding()
    {
        fFolding=true;
    }
    
    @Override
    protected void generateName()
    {
        fName="Мягкое_кресло";
    }
    
     @Override
    public String toString()
    {
        String str=new String();
        String str1="да", str2="нет";
        if(fFolding==true)
            str=super.toString()+"_Раскладной:"+str1;
        else
            str=super.toString()+"_Раскладной:"+str2;
        return str;
    }
     
    @Override
     public boolean equals(Object obj)
     {
         if(obj==null)
             return false;
         if(this==obj)
             return true;
         if(obj instanceof SoftChair)
         {
             SoftChair temp=(SoftChair)obj;
             return this.fFolding==temp.fFolding &&
                     this.fCost==temp.fCost &&
                     this.fModel.equals(temp.fModel) &&
                     this.fName.equals(temp.fName) &&
                     this.fPacking.equals(temp.fPacking) &&
                     this.fPrice==temp.fPrice &&
                     this.fSheathing.equals(temp.fSheathing) &&
                     this.scId==this.scId;
         }
         else return false;
                  
     }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (this.fFolding ? 1 : 0);
        hash = 31 * hash + this.scId;
        return hash;
    }
    
}
