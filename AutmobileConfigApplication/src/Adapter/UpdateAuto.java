package Adapter;


import java.io.IOException;

public interface UpdateAuto {

	void setOptnSetName(String modelName, String OptionSetName, String newName);

	void setOptnPrice(String modelName, String OptionSetName, String OptionName, float newPrice);

	void setOptnSetName(String modelName, int i, String newName) throws IOException;

	void setOptnPrice(String modelName, int i, int j, float newPrice) throws IOException;

	void setOptnName(String modelName, int i, int j, String newName) throws IOException;

	void addOptnChoice(String optSetName, String optionName);

	void addOptnChoice(int i, int j) throws IOException;

	void removeOptnChoice(int i);

	void setOptnChoice(int i, int j) throws IOException;

	void setOptnChoice(String optSetName, String optionName);

}
