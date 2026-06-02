
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
