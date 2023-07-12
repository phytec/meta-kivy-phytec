PACKAGECONFIG ??= " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland gles2', '', d)} \
"
