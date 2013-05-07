Jazzlib2me
==========

The pure java implementation of java.util.zip for J2ME. It's reference Jazzlib 

http://jazzlib.sourceforge.net/


ChangeLog
---------

* Remove the Dependency of Object.clone()
* Add RandomAccessFile/BufferedInputStream class
* Add ProxyInflaterInputStream class let InputStream.available() return full stream length (it's a bad behavior on J2ME programmer)

TODO
----

[x] Upload a distribution jar file
[x] Add the sample codes
[x] Add the Ant Script

License
-------

This code is released under the GPL license with a special exception:
As a special exception, if you link this library with other files to
produce an executable, this library does not by itself cause the
resulting executable to be covered by the GNU General Public License.
This exception does not however invalidate any other reasons why the
executable file might be covered by the GNU General Public License. 