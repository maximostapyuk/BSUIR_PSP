/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturestore.fobject.soft;

public class Sofa extends SoftFurniture{
    private boolean fArmset;
    private static int sNum=0;
    private int sId;
    public Sofa()
    {
        super();
        fArmset=false;
        generateName();
        sNum=sNum+1;
        sId=sNum;
    }
    public void setArmset()
    {
        fArmset=true;
    }
    @Override
    protected void generateName()
    {
        fName="Диван";
    }
    
    @Override
    public String toString()
    {
        String str=new String();
        String str1="есть", str2="нет";
        if(fArmset==true)
            str=super.toString()+"_Подлокотники:"+str1;
        else
            str=super.toString()+"_Подлокотники:"+str2;
        return str;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Sofa)
        {
            Sofa temp=(Sofa)obj;
            return this.fArmset==temp.fArmset &&
                    this.fCost==temp.fCost &&
                    this.fModel.equals(temp.fModel) &&
                    this.fName.equals(temp.fName) &&
                    this.fPacking.equals(temp.fPacking) &&
                    this.fPrice==temp.fPrice &&
                    this.fSheathing.equals(temp.fSheathing) &&
                    this.sId==temp.sId;
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.fArmset ? 1 : 0);
        hash = 83 * hash + this.sId;
        return hash;
    }
}
