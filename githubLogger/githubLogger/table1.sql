
-- User Table
CREATE TABLE commit_user (
    id          BIGSERIAL PRIMARY KEY,
    username    VARCHAR(100) NOT NULL UNIQUE,
    avatar_url  VARCHAR(255)
);

-- Repository Table
CREATE TABLE repository (
    id          BIGSERIAL PRIMARY KEY,
    repo_name   VARCHAR(100) NOT NULL UNIQUE
);

-- Commit Records Table
CREATE TABLE commit_records (
    id          BIGSERIAL PRIMARY KEY,
    event_id    VARCHAR(50) NOT NULL UNIQUE,
    commit_head VARCHAR(100),
    before_hand VARCHAR(100),
    created_at  VARCHAR(50)
);

-- User Repository Mapping Table
CREATE TABLE user_repository (
    user_id     BIGINT,
    repo_id     BIGINT,
    PRIMARY KEY (user_id, repo_id)
);

-- Altering the table to add the user_id which refers to the id coloum in the 
-- commit_user table "id" column
ALTER TABLE commit_records 
ADD COLUMN user_id BIGINT REFERENCES commit_user(id);


ALTER TABLE commit_records 
ADD COLUMN repo_id BIGINT REFERENCES repository(id);

-- Defining relationship with commit_user and repository table 
-- User repository table holds both the foriegn keys
ALTER TABLE user_repository
ADD CONSTRAINT fk_user
FOREIGN KEY (user_id) REFERENCES commit_user(id);

ALTER TABLE user_repository
ADD CONSTRAINT fk_repo
FOREIGN KEY (repo_id) REFERENCES repository(id);