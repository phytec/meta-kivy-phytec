PACKAGECONFIG_GL = "gles2"
PACKAGECONFIG:remove = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'x11', '', d)}"
