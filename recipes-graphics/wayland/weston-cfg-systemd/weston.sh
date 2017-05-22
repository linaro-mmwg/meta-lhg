#!/bin/sh
# Weston

#uncomment some part of the following line if you like:
# - see the weston log
#    LOG_FILE: file on which the log are writed
# - use a software compositor instead of egl compositor
#    USE_PIXMAN: populate the variable to use the software compositor on
#    weston
# - add some new option to weston application
#   ST_WESTON_ADDONS
# - debug weston via openvt
#   DEBUG_OPENGL_VIA_OPENVT: file on which the all stdout, sdterr trace
#   are stocked

. /etc/profile

#LOG_FILE=/tmp/weston.log
#USE_PIXMAN=1
#WESTON_ADDONS
#DEBUG_OPENGL_VIA_OPENVT=/tmp/opengl.log
BACKEND=drm-backend.so

mkdir -p $XDG_RUNTIME_DIR
chmod 0700 $XDG_RUNTIME_DIR

. /etc/profile

#log file managment on weston CMD line
CMD_LINE_WESTON=""
if [ -z $LOG_FILE ];
then
    CMD_LINE_WESTON=" "
else
    if [ -f $LOG_FILE ]; then
        rm $LOG_FILE
    fi
    CMD_LINE_WESTON="--log=$LOG_FILE"
fi
if [ -z "$WESTON_IDLE_TIME" ];
then
    WESTON_IDLE_TIME=648000
fi
#compositor managment on CMD line
CMD_LINE_WESTON="$CMD_LINE_WESTON  --backend=$BACKEND"
if [ -z $USE_PIXMAN ];
then
    echo "";
else
    CMD_LINE_WESTON="$CMD_LINE_WESTON --use-pixman"
fi

#Addons paramaters
if [ -n $WESTON_ADDONS ];
then
    CMD_LINE_WESTON="$CMD_LINE_WESTON $WESTON_ADDONS"
fi

# See how we were called.
case "$1" in
  start)
    echo "Starting Weston"
    if [ -n "$DEBUG_OPENGL_VIA_OPENVT" ];
    then
        echo "[DEBUG] use script /tmp/launch_basic_weston.sh"
        echo "[DEBUG] output saved on file $DEBUG_OPENGL_VIA_OPENVT"
        #generate a wrapper script to launch weston
cat > /tmp/launch_basic_weston.sh << EOF
/usr/bin/weston -i$WESTON_IDLE_TIME $CMD_LINE_WESTON 2>&1 > $DEBUG_OPENGL_VIA_OPENVT
EOF
        chmod +x /tmp/launch_basic_weston.sh
        openvt -s -w -- /tmp/launch_basic_weston.sh
    else
        echo "/usr/bin/weston -i$WESTON_IDLE_TIME $CMD_LINE_WESTON"
        openvt -s -w -- /usr/bin/weston -i$WESTON_IDLE_TIME $CMD_LINE_WESTON
    fi
    ;;

  stop)
    echo "Stopping Weston"
    pid_weston=`pidof weston`
    kill -9 $pid_weston
    ;;

  status)
    if pidof weston >/dev/null
    then
        echo "Weston: running"
        echo "CMDLINE of weston:"
        echo " /usr/bin/weston -i$WESTON_IDLE_TIME $CMD_LINE_WESTON"
    else
        echo "Weston: not running"
        exit 3
    fi
    exit 0
    ;;

  restart)
    $0 stop
    sleep 1
    $0 start
    ;;

  *)
    echo  "Usage: weston.sh {start|stop|status|restart}"
    exit 1
    ;;
esac

exit 0