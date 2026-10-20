class RetroCartridge {
    public void insertCartridge() {
        System.out.println("running game from retro cartridge");
    }
}

class ModernConsole {
    public void playDigital(DigitalGame game) {
        game.playDigital();
    }
}

interface DigitalGame {
    void playDigital();
}

class CartridgeAdapter implements DigitalGame {
    private RetroCartridge retroCartridge;

    public CartridgeAdapter(RetroCartridge retroCartridge) {
        this.retroCartridge = retroCartridge;
    }

    @Override
    public void playDigital() {
        retroCartridge.insertCartridge();
    }
}

public class Main {
    public static void main(String[] args) {
        RetroCartridge retroCartridge = new RetroCartridge();
        DigitalGame adapter = new CartridgeAdapter(retroCartridge);

        ModernConsole console = new ModernConsole();
        console.playDigital(adapter);
    }
}
