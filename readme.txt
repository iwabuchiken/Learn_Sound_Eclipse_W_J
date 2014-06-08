------------------------

	Paths
	
------------------------
C:\WORKS\WS\Eclipse_Kepler\Learn_Sound_Eclipse_W_J
pushd C:\WORKS\WS\Eclipse_Kepler\Learn_Sound_Eclipse_W_J

-Djava.library.path="${workspace_loc}/com.example.jni/resources;${env_var:PATH}"
-Djava.library.path="${workspace_loc:/JNI_Test/resources};${env_var:PATH}"

java com.example.jni.JNITest
java -Djava.library.path=../resources com.example.jni.JNITest

xcopy "${BuildArtifactFilePrefix}${BuildArtifactFileName}" "${workspace_loc:/JNI_Test/resources/}" /Y
xcopy "${BuildArtifactFilePrefix}${BuildArtifactFileName}" "${workspace_loc:/JNI_Test/resources/hello.dll}" /Y

------------------------

	Build steps
	
------------------------
C++		Build
copy	to: <Java project folder>/resources
rename	to: "hello"		from: "...."
run		Java project

------------------------

	Git

------------------------
git init && git add . && gitk

m

v-1.0
---
Initial

g p origin master
