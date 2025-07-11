--------------------------------- 유저
CREATE TABLE user_tbl (
	user_id		VARCHAR(20),
	user_pw		VARCHAR(20),
	user_name	VARCHAR(20),
	PRIMARY KEY (user_id)
);
DROP TABLE user_tbl;

INSERT INTO user_tbl VALUES ('junotest', '1234', '최준오');