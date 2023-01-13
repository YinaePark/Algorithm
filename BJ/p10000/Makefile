SANFLAGS = -fsanitize=address
CXXFLAGS += -Wall -std=c++17 -pedantic $(SANFLAGS)
LDFLAGS += $(SANFLAGS)    

main:	main.o
		$(CXX) -o $@ $^ $(LDFLAGS) 

clean:
		$(RM) main *.o