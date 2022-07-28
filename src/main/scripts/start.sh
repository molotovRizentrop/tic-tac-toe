#!/usr/bin/env bash
#
#script for unix OS
#
cd "$(dirname "$0")" || exit

java -jar ${project.build.finalName}.jar
echo "Press enter to countinue . . . "
read -r name