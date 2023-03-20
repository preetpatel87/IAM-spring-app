
INSERT INTO users (name, username, password, role) VALUES ('tester1', 'testuser1', 'password', ARRAY ['Viewer']);
INSERT INTO users (name, username, password, role) VALUES ('tester2', 'testuser2', 'password', ARRAY ['Moderator']);
INSERT INTO users (name, username, password, role) VALUES ('tester3', 'testuser3', 'password', ARRAY ['Creator']);

INSERT into rbac (role, permissions) VALUES ('Viewer', ARRAY ['getThread','getThreadList','getCommentsList','createComment']);
INSERT into rbac (role, permissions) VALUES ('Creator', ARRAY ['getThread','getThreadList','createThread','getCommentsList','createComment']);
INSERT into rbac (role, permissions) VALUES ('Moderator', ARRAY ['getThread','getThreadList','createThread','deleteThread','getCommentsList','createComment','deleteComment']);
INSERT into rbac (role, permissions) VALUES ('Admin', ARRAY ['getThread','getThreadList','createThread','editThread','deleteThread','getCommentsList','createComment','editComment','deleteComment']);

INSERT INTO threads (thread_id, thread_name, thread_description, date_created) VALUES (1,'testThread', 'testThread Description', now());