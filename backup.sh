#!/bin/bash

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(dirname "$SCRIPT_DIR")"
SRC_DIR="$PROJECT_ROOT/FrontendA"
BACKUP_BASE="$PROJECT_ROOT/backups"
BACKUP_DIR="$BACKUP_BASE/frontend_backup_$(date +'%Y-%m-%d_%H-%M-%S')"
LOG_DIR="$SRC_DIR/logs"
LOG_FILE="$BACKUP_DIR/backup.log"

mkdir -p "$BACKUP_DIR"

echo "Backing up frontend files..."
cp -r "$SRC_DIR"/*.html "$BACKUP_DIR" 2>> "$LOG_FILE"
cp -r "$SRC_DIR"/*.css "$BACKUP_DIR" 2>> "$LOG_FILE"

if [ -d "$LOG_DIR" ]; then
    echo "Backing up log files..."
    cp -r "$LOG_DIR" "$BACKUP_DIR" 2>> "$LOG_FILE"
else  
    echo "No logs directory found." >> "$LOG_FILE"
fi

echo "Backup completed at $(date)" >> "$LOG_FILE"