package chap10.dto;

public class BoardDto {
	private Integer board_idx;
	private String board_title;
	private String board_content;
	private String write_name;
	private String write_passward;

	public BoardDto(Integer board_idx, String board_title, String board_content, String write_name,
			String write_passward) {
		this.board_idx = board_idx;
		this.board_title = board_title;
		this.board_content = board_content;
		this.write_name = write_name;
		this.write_passward = write_passward;
	}
	public BoardDto(Integer board_idx, String board_title, String write_name) {
		this.board_idx = board_idx;
		this.board_title = board_title;
		this.write_name = write_name;
	}
	
	

	public Integer getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(Integer board_idx) {
		this.board_idx = board_idx;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getWrite_name() {
		return write_name;
	}

	public void setWrite_name(String write_name) {
		this.write_name = write_name;
	}

	public String getWrite_passward() {
		return write_passward;
	}

	public void setWrite_passward(String write_passward) {
		this.write_passward = write_passward;
	}
}
