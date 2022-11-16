package Scale;

import java.io.IOException;

/**
 * Internal API
 */
public interface EditThread {

	public void editThread(String ModelName, int operation, String[] args) throws IOException, InterruptedException;

}