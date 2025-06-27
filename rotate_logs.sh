# This script is designed for Linux or Unix-based systems.
# It rotates and compresses all .log files inside ./logs/ every week.
# Make sure gzip and cron are installed and that you have permission to add cron jobs.
#!/bin/bash

LOG_DIR="./logs"
ARCHIVE_DIR="$LOG_DIR/archive"
DATE_SUFFIX=$(date +"%Y-%m-%d")
SCRIPT_PATH=$(realpath "$0")

mkdir -p "$ARCHIVE_DIR"

# for logs directory
for LOG_FILE in "$LOG_DIR"/*.log; do
    [ -e "$LOG_FILE" ] || continue
    BASENAME=$(basename "$LOG_FILE")
    ARCHIVE_FILE="$ARCHIVE_DIR/${BASENAME%.log}-$DATE_SUFFIX.log"    
    mv "$LOG_FILE" "$ARCHIVE_FILE"
    gzip "$ARCHIVE_FILE"
    echo "[INFO] $(date) - Rotated and compressed $BASENAME"
done

# for project root 
for ROOT_LOG_FILE in ./*.log; do
  [ -e "$ROOT_LOG_FILE" ] || continue
  BASENAME=$(basename "$ROOT_LOG_FILE")
  ARCHIVE_FILE="$ARCHIVE_DIR/${BASENAME%.log}-$DATE_SUFFIX.log"
  
  mv "$ROOT_LOG_FILE" "$ARCHIVE_FILE"
  gzip "$ARCHIVE_FILE"
  echo "[INFO] $(date) - Rotated and compressed $BASENAME from root directory"
done

# if cron don't work.... please install cron on your system first then try again

CRON_CMD="0 2 * * 0 $SCRIPT_PATH >> ${SCRIPT_PATH%.sh}.log 2>&1"
CRON_EXISTS=$(crontab -l 2>/dev/null | grep -F "$SCRIPT_PATH")
if [ -z "$CRON_EXISTS" ]; then
    (crontab -l 2>/dev/null; echo "$CRON_CMD") | crontab -
    echo "[INFO] Cron job added to run weekly: $CRON_CMD"
else
    echo "[INFO] Cron job already exists. No changes made."
fi
