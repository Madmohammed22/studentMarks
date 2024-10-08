# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: mmad <mmad@student.42.fr>                  +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2024/07/08 12:20:21 by mmad              #+#    #+#              #
#    Updated: 2024/08/08 18:41:57 by mmad             ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

# Makefile for compiling and running Java files from multiple directories

# Variables
JAVAC = javac
JAVA = java
SRC_DIR = src
CLASSES_DIR = classes
SOURCES = $(wildcard $(SRC_DIR)/**/*.java)
CLASSES = $(SOURCES:$(SRC_DIR)/%.java=$(CLASSES_DIR)/%.class)
MAIN_CLASS = main.Main # Fully qualified name of the Main class

# Default target
all: $(CLASSES_DIR) $(CLASSES)

# Rule to create the classes directory
$(CLASSES_DIR):
	mkdir -p $(CLASSES_DIR)

# Rule to compile .java files to .class files
$(CLASSES_DIR)/%.class: $(SRC_DIR)/%.java
	$(JAVAC) -d $(CLASSES_DIR) -cp $(SRC_DIR) $<

# Rule to run the main class
run: all
	$(JAVA) -cp $(CLASSES_DIR) $(MAIN_CLASS)

# Clean target to remove generated files
clean:
	rm -rf $(CLASSES_DIR)

.PHONY: all clean run
