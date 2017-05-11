#!/bin/sh

PATH=/sbin:/bin:/usr/sbin:/usr/bin

mkdir /proc
mkdir /sys
mount -t proc proc /proc
mount -t sysfs sysfs /sys
mount -t devtmpfs none /dev

modprobe isofs 2> /dev/null
mkdir -p /run
mkdir -p /var/run

exec sh
