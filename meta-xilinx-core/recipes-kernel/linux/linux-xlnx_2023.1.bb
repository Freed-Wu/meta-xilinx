LINUX_VERSION = "5.15.0"
KBRANCH="master"
SRCREV = "b5823a600d05ca886cfea66e926d74f1c143484f"

KCONF_AUDIT_LEVEL="0"

include linux-xlnx.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"