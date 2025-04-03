#!/bin/bash

# Create directories if they don't exist
mkdir -p target/classes

# Compile all Java files
echo "Compiling Java files..."
javac -d target/classes src/main/java/sandbox/*.java

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    
    # Run the main application
    echo -e "\nRunning MainApplication:"
    java -cp target/classes sandbox.MainApplication
    
    # Provide options to run other demos
    echo -e "\nOptions:"
    echo "1. Run Collections Demo"
    echo "2. Run Generics Demo"
    echo "3. Exit"
    
    read -p "Enter your choice (1-3): " choice
    
    case $choice in
        1)
            echo -e "\nRunning CollectionsDemo:"
            java -cp target/classes sandbox.CollectionsDemo
            ;;
        2)
            echo -e "\nRunning GenericsDemo:"
            java -cp target/classes sandbox.GenericsDemo
            ;;
        3)
            echo "Exiting."
            ;;
        *)
            echo "Invalid choice. Exiting."
            ;;
    esac
else
    echo "Compilation failed!"
fi