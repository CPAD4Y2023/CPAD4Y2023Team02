import 'package:flutter/material.dart';

class OnBordingScreen extends StatefulWidget {
  const OnBordingScreen({super.key});

  @override
  State<OnBordingScreen> createState() => _OnBordingScreenState();

}

class _OnBordingScreenState extends State<OnBordingScreen> {

  late PageController _pageController;
  int _pageIndex = 0;

  @override
  void initState() {
    _pageController = PageController(initialPage: 0);
    super.initState();
  }

  @override
  void dispose() {
    _pageController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(int.parse("0xffffffff")),
      body: SafeArea(
        child: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            Expanded(
              child: PageView.builder(
                itemCount: onbording_data.length,
                controller: _pageController,
                onPageChanged: (index) {
                  setState(() {
                    _pageIndex = index;
                  });
                },
                itemBuilder: (context, index) => OnBordingContent(
                  image: onbording_data[index].image,
                  title: onbording_data[index].title,
                  description: onbording_data[index].description,
                ),
              ),
            ),
            Padding(
              padding: const EdgeInsets.fromLTRB(30, 0, 20, 55),
              child: Row(
                children: [
                  ...List.generate(onbording_data.length, (index) => 
                    Padding(
                      padding: const EdgeInsets.only(right: 4),
                      child: lineIndicator(isActive: index == _pageIndex )
                    )
                  ) ,
                  const Spacer(),
                  SizedBox(
                    height: 60,
                    width: 60,
                    child: OnBordingButton(pageIndex: _pageIndex, pageController: _pageController,),
                  )
                ],
              ),
            ),
          ],
        ),
        ),
      ),
    );
  }
}


class OnBordingButton extends StatelessWidget {
  const OnBordingButton({super.key, required this.pageIndex, required this.pageController});
  
  final int pageIndex;
  final PageController pageController;

  @override
  Widget build(BuildContext context) {
    return pageIndex!=2? 
      TextButton(
        style: ButtonStyle(
          foregroundColor: MaterialStateProperty.all<Color>(Colors.green),
        ),
        onPressed: () {
          pageController.jumpTo(700);
        },
        child: const Text("Skip"),
      ):
      TextButton(
        style: ButtonStyle(
          foregroundColor: MaterialStateProperty.all<Color>(Colors.green),
        ),
        onPressed: () {
          // implement the sign up logic
        },
        child: const Text("Signup"),
      );
  }
}

class OnBoard {
  final String image, title, description;

  OnBoard({
    required this.image,
    required this.title,
    required this.description,
  });
}

final List<OnBoard> onbording_data = [
  OnBoard(
    image: "images/onbording/first.png",
    title: "Recycle",
    description: "Recycling made as easy as ordering pizza. We Strongly believe nothing is waste, Everything has a right place."
  ),
  OnBoard(
    image: "images/onbording/second.png",
    title: "Select",
    description: "Bringing convenience to recycling, one tap at a time."
  ),
  OnBoard(
    image: "images/onbording/last.png",
    title: "Earn",
    description: "Don't trash it, recycle and cash it with just few clicks."
  ),
];

class OnBordingContent extends StatelessWidget {
  const OnBordingContent({super.key, required this.image, required this.title, required this.description});

  final String image, title, description;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.fromLTRB(22, 0, 22, 0),
      child: Column(
        children: [
          const Spacer(),
          Image.asset(image, height: 280),
          const Spacer(),
          Align(
            alignment: Alignment.centerLeft,
            child: Text(
                title,
                style: TextStyle(color: Color(int.parse("0xff646464")), fontSize: 22),
              ),
          ),
          const SizedBox(height: 16),
          Text(
            description,
            style: TextStyle(color: Color(int.parse("0xff9B9B9B"))),
          ),
          const Spacer(),
        ],
      ),
    );
  }
}

class lineIndicator extends StatelessWidget {
  const lineIndicator({super.key, this.isActive = false});

  final bool isActive;

  @override
  Widget build(BuildContext context) {
    return AnimatedContainer(
      duration: const Duration(milliseconds: 300),
      height: isActive ? 12: 4,
      width: 4,
      decoration: BoxDecoration(
        color: isActive ?Colors.green : Color(int.parse("0xff86D377")),
        borderRadius: const BorderRadius.all(Radius.circular(12)),
      ),
    );
  }
}