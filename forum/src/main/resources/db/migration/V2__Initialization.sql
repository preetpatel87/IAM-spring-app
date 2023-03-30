
INSERT into rbac (role, permissions) VALUES ('Viewer', ARRAY ['getThread','getThreadList','getCommentsList','createComment']);
INSERT into rbac (role, permissions) VALUES ('Creator', ARRAY ['getThread','getThreadList','createThread','getCommentsList','createComment']);
INSERT into rbac (role, permissions) VALUES ('Moderator', ARRAY ['getThread','getThreadList','createThread','deleteThread','getCommentsList','createComment','deleteComment']);
INSERT into rbac (role, permissions) VALUES ('Admin', ARRAY ['getThread','getThreadList','createThread','editThread','deleteThread','getCommentsList','createComment','editComment','deleteComment','editUser','getUserList']);

INSERT INTO users (name, username, password, role) VALUES ('viewer', 'viewer', 'password', ARRAY ['Viewer']);
INSERT INTO users (name, username, password, role) VALUES ('moderator', 'moderator', 'password', ARRAY ['Moderator']);
INSERT INTO users (name, username, password, role) VALUES ('creator', 'creator', 'password', ARRAY ['Creator']);
INSERT INTO users (name, username, password, role) VALUES ('admin', 'admin', 'password', ARRAY ['Admin']);