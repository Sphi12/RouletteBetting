package masivian.test.roulettebetting.model;

public class GenericResponse {

	private String messageResponse;
	private String CodeResponsse;

	public GenericResponse(String messageResponse, String codeResponsse) {
		super();
		this.messageResponse = messageResponse;
		CodeResponsse = codeResponsse;
	}

	public String getMessageResponse() {
		return messageResponse;
	}

	public void setMessageResponse(String messageResponse) {
		this.messageResponse = messageResponse;
	}

	public String getCodeResponsse() {
		return CodeResponsse;
	}

	public void setCodeResponsse(String codeResponsse) {
		CodeResponsse = codeResponsse;
	}
}
