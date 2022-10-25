package Adapter;


import java.io.IOException;

/**
 * Provides changes to the automotive instance via Update,Delete methods
 * <p>
 * Why this????
 */
public interface UpdateAuto {

	//search model name, search OptionSetname, update with newName
	void updateOptnSetName(String modelName, String OptionSetName, String newName);

	//search model name,search OptionSetname, search Option , update with NewName
	void updateOptnPrice(String modelName, String OptionSetName, String OptionName, float newPrice);

	float getTotalPrice();

	void addOptnChoice(String optSetName, String optionName);

	void addOptnChoice(int i, int j) throws IOException;

	void removeOptnChoice(int i);

	void setOptnChoice(int i, int j) throws IOException;

	void setOptnChoice(String optSetName, String optionName);

}
