#!/bin/bash
runas /noprofile /user:Administrator "rpm --import https://www.mongodb.org/static/pgp/server-6.0.asc"
runas /noprofile /user:Administrator "zypper addrepo --gpgcheck \"https://repo.mongodb.org/zypper/suse/15/mongodb-org/6.0/x86_64/\" mongodb"
runas /noprofile /user:Administrator "zypper -n install mongodb-org"
runas /noprofile /user:Administrator "systemctl start mongod"

