#!/bin/bash

# This file creates a local environment for Maven dependencies
# to use do
# . setenv.sh
# to restore previous configuration do
# endenv

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"

export OLD_MAVEN_OPTS=$MAVEN_OPTS

export MAVEN_OPTS="-Dmaven.repo.local=$SCRIPT_DIR/.m2/"

export OLD_PS1=$PS1

alias endenv='export MAVEN_OPTS=$OLD_MAVEN_OPTS && export PS1=$OLD_PS1'

PS1='STAMP@\W> '

