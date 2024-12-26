package pe.com.bn.modc.common;

import java.text.NumberFormat;

import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.data.category.CategoryDataset;
 

public class CustomLabelGenerator extends AbstractCategoryItemLabelGenerator implements CategoryItemLabelGenerator {
	 
	 
	   public CustomLabelGenerator() {
	      super("", NumberFormat.getInstance());

	   }


	   public String generateLabel(CategoryDataset dataset, int series,int category) {

	      String result = null;
	      if(series==0){
		      Number value = dataset.getValue(series, category);
		      double numero = 0.0;
		      if(value!=null){
		    	  numero = (new Double(value.toString())).doubleValue();
		      }
		      result = Util.formatNumber(numero, Constant.NUM_DECIMAL_CON_COMA_2,  Constant.NUM_DIGITOS_DECIMAL_0); 
	      }
	      return result;   
	   }


	   public String generateRowLabel(CategoryDataset arg0, int arg1) {
	      return null;
	   }


	   public String generateColumnLabel(CategoryDataset arg0, int arg1) {
	      return null;
	   }
}
