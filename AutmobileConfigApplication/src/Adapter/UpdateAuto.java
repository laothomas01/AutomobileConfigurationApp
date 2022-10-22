package Adapter;

/**
 * Provides changes to the automotive instance via Update,Delete methods
 * <p>
 * Why this????
 */
public interface UpdateAuto {

	//search model name, search OptionSetname, update with newName
	void updateOptionSetName(String modelName, String OptionSetName, String newName);

	//search model name,search OptionSetname, search Option , update with NewName
	void updateOptionPrice(String modelName, String OptionSetName, String OptionName, float newPrice);

	float getTotalPrice();

	void addOptionChoice(String optSetName, String option);

	void addOptionChoice(int i, int j);

	void removeOptionChoice(int i);

}
