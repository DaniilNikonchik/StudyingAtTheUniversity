# makefile Laba3

.SUFFIXES: .class .java

PACK=Laba3
TARG=Main
JC=javac -g
JM=java -ea -jar
JR=jar -cfe

OBJ=$(PACK)\Vector.class \
    $(PACK)\Main.class

.java.class:
	$(JC) $<

run: build
	$(JM) $(TARG).jar

build: 	$(OBJ)
	$(JR) $(TARG).jar $(PACK).Main $(OBJ)

clean:
	for %%f in ($(OBJ)) do del %%f
	del $(TARG).jar

$(PACK)\Vector.class: $(PACK)\Vector.java makefile

$(PACK)\Main.class: $(PACK)\Main.java makefile

# eof makefile Laba3