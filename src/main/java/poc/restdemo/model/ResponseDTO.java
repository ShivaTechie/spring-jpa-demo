package poc.restdemo.model;

public class ResponseDTO<T> {

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResponseDTO(T data) {
		super();
		this.data = data;
	}

	public ResponseDTO() {
		super();
	}

	@Override
	public String toString() {
		return "ResponseDTO [data=" + data + "]";
	}

}
