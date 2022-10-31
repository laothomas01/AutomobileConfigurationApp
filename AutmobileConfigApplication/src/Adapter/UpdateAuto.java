package Adapter;


import java.io.IOException;

public interface UpdateAuto {

	void updateOptnSetName(String modelName, String OptionSetName, String newName);

	void updateOptnPrice(String modelName, String OptionSetName, String OptionName, float newPrice);

	float getTotalPrice();

	void addOptnChoice(String optSetName, String optionName);

	void addOptnChoice(int i, int j) throws IOException;

	void removeOptnChoice(int i);

	void setOptnChoice(int i, int j) throws IOException;

	void setOptnChoice(String optSetName, String optionName);

}
