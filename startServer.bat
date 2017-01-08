@echo off

SET postgres_install_dir="C:\Program Files\PostgreSQL\9.6"
SET postgres_db_data_dir="data"

cd /d %postgres_install_dir%
bin\postgres.exe -D %postgres_db_data_dir%

REM Sleep because postmaster process has to be restarted or something
TIMEOUT 60

cd /d %postgres_install_dir%
bin\postgres.exe -D %postgres_db_data_dir%
