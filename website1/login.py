
#!/usr/bin/python

import sqlite3

conn = sqlite3.connect('users.db')
print ("Opened database successfully")

conn.execute('''CREATE TABLE USERS
         (
         NAME           TEXT    NOT NULL,
         PASS           INT     NOT NULL,
         ;''')
print ("Table created successfully")

conn.close()