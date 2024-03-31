use clap::Parser;
use colored::Colorize;

#[derive(Parser)]
struct Options {
    #[clap(default_value = "What's up doc!🥕")]
    /// What does the bunny say?
    message: String,
    #[clap(short = 'd', long = "dead")]
    /// Make the bunny appear dead
    dead: bool,
    #[clap(short = 'f', long = "file")]
    /// Load the picture from the specified file
    bunnyfile: Option<std::path::PathBuf>,
}

fn main() {
    let options = Options::parse();

    let message = options.message;
    let eye = if options.dead { "X" } else { "0" };
    if message.to_lowercase() == "woof" {
        eprintln!("A bunny shouldn't bark like a dog.")
    }

    match &options.bunnyfile {
        Some(path) => {
            let bunny_template = std::fs::read_to_string(path)
                .expect(
                    &format!("could not read file {:?}", path)
                );
            let eye = format!("{}", eye.red().bold());
            let bunny_pic = bunny_template.replace("{eye}", &eye);
            println!("{}", message.bright_yellow().underline().on_purple());
            println!("{}", &bunny_pic);
        },
        None => {
            println!(
                "{}",
                message.bright_yellow().underline().on_purple());
            println!("\\");
            println!(" \\");
            println!("  \\");
            println!("     //  //");
            println!("    /\\__/\\");
            println!("    ( {eye} {eye} )", eye = eye.red().bold());
            println!("    =\\ I /=");
            println!("      ---   ");
        }
    }
}
