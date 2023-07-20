
package bsu.fpmi.edupract;

import java.beans.PropertyEditorSupport;
import javax.swing.JLabel;

public class MyLabelEditor extends PropertyEditorSupport {
	
	@Override
	public String[] getTags() {
		return new String[] {"label"};
	}
	
	@Override
	public void setAsText(String s) {
		setValue(new JLabel(s));
	}

	@Override 
	public String getAsText() {
		return ((JLabel)getValue()).getText();
	}

	@Override
	public String getJavaInitializationString() {
		return "";
	}
	
}
