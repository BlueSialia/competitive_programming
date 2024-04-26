use std::io;

const MIN: usize = 0;
const MAX: usize = 10000;

static mut MEMORY: [usize; 100000000] = [0; 100000000];

/// Reads a user input line.
fn read_line() -> String {
    let mut input = String::new();
    io::stdin()
        .read_line(&mut input)
        .expect("Error: Unable to read user input.");
    input
}

/// Returns the list of prime numbers from 2 to `upperbound`.
fn cycle_length(num: usize) -> usize {
    unsafe {
        if MEMORY[num] != 0 {
        } else if num == 1 {
            MEMORY[num] = 1;
        } else if num % 2 == 0 {
            MEMORY[num] = cycle_length(num / 2) + 1;
        } else {
            MEMORY[num] = cycle_length(3 * num + 1) + 1;
        }
        MEMORY[num]
    }
}

/// Returns the maximum cycle length between and including the provided numbers.
fn solve(small_num: usize, large_num: usize) -> usize {
    let mut max_cycle_length = 0;
    for i in small_num..=large_num {
        let current_cycle_length = cycle_length(i);
        if current_cycle_length > max_cycle_length {
            max_cycle_length = current_cycle_length;
        }
    }
    max_cycle_length
}

fn main() {
    loop {
        // Convert input into pair of numbers
        let mut pair: Vec<usize> = read_line()
            .split(' ')
            .filter_map(|s| s.trim().parse::<usize>().ok())
            .collect::<Vec<usize>>();
        // Check if the pair of numbers are valid
        if pair.len() != 2 {
            panic!("Invalid number of numbers.")
        }
        // Print original numbers
        print!("{} {} ", pair[0], pair[1]);
        // Print solution
        pair.sort();
        if pair[0] < MIN {
            panic!("The given number is too big.")
        }
        if pair[1] > MAX {
            panic!("The given number is too big.")
        }
        print!("{} ", solve(pair[0], pair[1]));
        println!();
    }
}
