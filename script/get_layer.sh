#!/bin/bash - 
#===============================================================================
#
#          FILE: get_layer.sh
#
#         USAGE: ./get_layer.sh
#
#   DESCRIPTION: script to get a full environment with 96 boards
#
#       OPTIONS: ---
#  REQUIREMENTS: ---
#          BUGS: ---
#         NOTES: ---
#        AUTHOR: Christophe Priouzeau (), christophe.priouzeau@linaro.org
#  ORGANIZATION: Linaro
#       CREATED: 09/23/2015 06:20:45 PM CEST
#      REVISION:  ---
#===============================================================================

set -o nounset                              # Treat unset variables as an error

oe_tmp_local_pwd=`pwd`

# get openembedded
oe_get_git_openemebedded() {
    if [ ! -d openembedded-core ];
    then
        git clone git://git.openembedded.org/openembedded-core.git
    fi
}

# get bitbake
oe_get_git_bitbake() {
    if [ -d openembedded-core ];
    then
        if [ ! -d bitbake ];
        then
            cd openembedded-core
            git clone git://git.openembedded.org/bitbake
            cd -
        fi
    fi
}

# get meta-openembedded
oe_get_git_meta_openemebedded() {
    if [ ! -d meta-openembedded ];
    then
        git clone git://git.openembedded.org/meta-openembedded
    fi
}

# get meta-qualcomm
oe_get_git_meta_qualcomm() {
    if [ ! -d meta-qualcomm ];
    then
        git clone https://github.com/ndechesne/meta-qualcomm.git
        git checkout -b jethro origin/jethro
    fi
}
# get meta-browser
oe_get_git_meta_browser() {
    if [ ! -d meta-browser ];
    then
        git clone https://github.com/linaro-home/meta-browser.git
        git checkout -b chromium_45 origin/chromium_45
    fi
}

# --------------------------
#         MAIN
# --------------------------
if [ ! -d $oe_tmp_local_pwd/meta-los ];
then
    echo "######################################"
    echo "ERROR: YOU MUST EXECUTE THE SCRIPT ON THE SAME DIRECTORY AS meta-los"
    echo "######################################"
    if [ "$0" != "$BASH_SOURCE" ]; then
        return 1
    else
        exit 1
    fi
fi

oe_get_git_openemebedded
oe_get_git_bitbake
oe_get_git_meta_openemebedded
oe_get_git_meta_browser
oe_get_git_meta_qualcomm

