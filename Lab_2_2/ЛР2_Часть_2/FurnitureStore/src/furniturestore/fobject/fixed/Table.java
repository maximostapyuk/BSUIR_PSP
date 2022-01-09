
package furniturestore.fobject.fixed;

public class Table extends FixedFurniture{
    private String fForma;
    private static int tNum=0;
    private int tId;
    public Table()
    {
        super();
        fForma=new String();
        generateName();
        tNum=tNum+1;
        tId=tNum;
    }
    
    public void setForma(String forma)
    {
        fForma=forma;
    }
    
    @Override
    protected void generateName()
    {
      fName="Стол";  
    }
    
    @Override
    public String toString()
    {
        String str=new String();
        str=super.toString()+"_форма_столешницы:"+fForma;
        return str;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Table)
        {
            Table temp=(Table)obj;
            return this.fCost==temp.fCost &&
                    this.fForma.equals(temp.fForma) &&
                    this.fMaterial.equals(temp.fMaterial) &&
                    this.fModel.equals(temp.fModel) &&
                    this.fName.equals(temp.fName) &&
                    this.fPrice==temp.fPrice &&
                    this.tId==temp.tId;
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.fForma != null ? this.fForma.hashCode() : 0);
        hash = 79 * hash + this.tId;
        return hash;
    }
    
}
