Node-webkit Demo app
> Sample application to test installed node-webkit

##Installation

In order to install Node-webkit follow below commands on Linux/Ubuntu.

Create installation directory in home directory of current user. <br />
This allows us to create execute `nw` without sudo.
```
mkdir ~/opt/packages && cd $_
```

Download latest stable version of Node-webkit.
```
wget http://dl.node-webkit.org/v0.9.2/node-webkit-v0.9.2-linux-x64.tar.gz
```

Unzip TAR in current directory `~/opt/packages`
```
gzip -dc node-webkit-v0.9.2-linux-x64.tar.gz | tar xf -
```

Create a link for package directory
```
ln -s ~/opt/packages/node-webkit-v0.9.2-linux-x64/ ~/opt/node-webkit
```

Add `~/opt/node-webkit` in `~/.profile` file
```
#Add node-webkit in $PATH
if [ -d "$HOME/opt/node-webkit" ]; then
	$PATH="$PATH:$HOME/opt/node-webkit"
fi
```

Source `~/.profile`
```
source ~/.profile
```

Check if node-webkit(`nw`) is in `$PATH`
```
which nw
```

Run `nw` to see if installation was successful.

This installation doesn' work for >= Ubuntu 13.04. Follow below steps to rectify 'libudev.so' problem.

### Fix the libudev.so.0 error

Below error occurs if you have tried to installed node-webkit on Ubuntu 13.04+ version.
```
error while loading shared libraries: libudev.so.0: cannot open shared object
file: No such file or directory
```

Main problem behind this is that newer versions of Ubunut uses libudev.so.1 but node-webkit was built against libudev.so.0. To fix this download any hex editor and update `libudev.so.0` to `libudev.so.1`.
```
apt-get install ghex
cd ~/opt/node-webkit
ghex nw

#Find and rectify dependency as mentioned above
```

Run `nw` and confirm if empty node-webkit window pops up.

Thats it !!!






