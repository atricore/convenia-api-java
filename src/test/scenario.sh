#!/usr/bin/env bash

# Function to display usage information
usage() {
  echo "Usage: $0 set <scenario_name> | advance"
  exit 1
}

# Check if the command is provided
if [ -z "$1" ]; then
  usage
fi

COMMAND=$1

case $COMMAND in
  set)
    if [ -z "$2" ]; then
      usage
    fi
    SCENARIO_NAME=$2
    curl -X POST http://localhost:8006/change-scenario/$SCENARIO_NAME
    echo
    echo "Scenario set to $SCENARIO_NAME"
    ;;

  advance)
    curl -X POST http://localhost:8006/advance-scenario
    echo
    echo "Scenario advanced"
    ;;

  *)
    usage
    ;;
esac
