/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturestore.fobject.fixed;

public class Chair extends FixedFurniture{
    private int maxWeight;
    private static int cNum=0;
    private int cId;
    public Chair()
    {
        super();
        maxWeight=0;
        generateName();
        cNum=cNum+1;
        cId=cNum;
    }
    
    public void setMaxWeight(int weight)
    {
        maxWeight=weight;
    }
    
    @Override
    protected void generateName()
    {
        fName="Стул";
    }
    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+"_грузоподъёмность:"+maxWeight+"кг";
        return str;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Chair )
        {
            Chair temp=(Chair)obj;
            return this.cId==temp.cId && this.fCost==temp.fCost &&
                    this.fMaterial.equals(temp.fMaterial) &&
                    this.fModel.equals(temp.fModel) &&
                    this.fName.equals(temp.fName) &&
                    this.fPrice==temp.fPrice &&
                    this.maxWeight==temp.maxWeight;
          
        }
        else 
            return false;
        }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.maxWeight;
        hash = 47 * hash + this.cId;
        return hash;
    }
    
    
}

