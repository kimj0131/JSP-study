package board.dto;

import java.sql.Date;

public class ReplyDTO {

	private Integer reply_id; // 댓글 번호 PK
	private Integer board_id; // 글 번호 FK
	private String reply_writer;
	private String reply_content;
	private String reply_password;
	private Integer reply_good_count;
	private Integer reply_bad_count;
	private Date reply_date;

	public ReplyDTO() {
	}

	public ReplyDTO(Integer reply_id, Integer board_id, String reply_writer, String reply_content,
			String reply_password, Integer reply_good_count, Integer reply_bad_count, Date reply_date) {
		super();
		this.reply_id = reply_id;
		this.board_id = board_id;
		this.reply_writer = reply_writer;
		this.reply_content = reply_content;
		this.reply_password = reply_password;
		this.reply_good_count = reply_good_count;
		this.reply_bad_count = reply_bad_count;
		this.reply_date = reply_date;
	}

	public Integer getReply_id() {
		return reply_id;
	}

	public void setReply_id(Integer reply_id) {
		this.reply_id = reply_id;
	}

	public Integer getBoard_id() {
		return board_id;
	}

	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}

	public String getReply_writer() {
		return reply_writer;
	}

	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public String getReply_password() {
		return reply_password;
	}

	public void setReply_password(String reply_password) {
		this.reply_password = reply_password;
	}

	public Integer getReply_good_count() {
		return reply_good_count;
	}

	public void setReply_good_count(Integer reply_good_count) {
		this.reply_good_count = reply_good_count;
	}

	public Integer getReply_bad_count() {
		return reply_bad_count;
	}

	public void setReply_bad_count(Integer reply_bad_count) {
		this.reply_bad_count = reply_bad_count;
	}

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}

}
